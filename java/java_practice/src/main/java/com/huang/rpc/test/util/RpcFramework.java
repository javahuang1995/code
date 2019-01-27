package com.huang.rpc.test.util;

import java.util.*;
import java.net.*;
import java.io.*;
import java.lang.reflect.*;
import java.lang.reflect.Proxy;

public class RpcFramework {
    /**
     * ��¶����
     *
     * @param service ����ʵ��
     * @param port    ����˿�
     * @throws Exception
     */
    public static void export(final Object service, int port) throws Exception {
        if (service == null) {
            throw new IllegalArgumentException("service instance == null");
        }
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port " + port);
        }
        System.out.println("Export service " + service.getClass().getName() + " on port " + port);
        // ����Socket�����
        ServerSocket server = new ServerSocket(port);
        for (; ; ) {
            try {
                // ����Socket����
                final Socket socket = server.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            try {
                                /* ��ȡ��������Server��������ȡ����*/
                                // ������������������Դ�ж�ȡ���󵽳�����
                                ObjectInputStream input = new ObjectInputStream(
                                    socket.getInputStream());
                                try {

                                    System.out.println("\nServer�������� �� ");
                                    String methodName = input.readUTF();
                                    System.out.println("methodName : " + methodName);
                                    // �����������ǲ����ݵģ�����ͨ��������Ͳ�������
                                    Class<?>[] parameterTypes = (Class<?>[])input.readObject();
                                    System.out.println(
                                        "parameterTypes : " + Arrays.toString(parameterTypes));
                                    Object[] arguments = (Object[])input.readObject();
                                    System.out.println("arguments : " + Arrays.toString(arguments));


                                    /* Server �������󣬽�����Ӧ*/
                                    ObjectOutputStream output = new ObjectOutputStream(
                                        socket.getOutputStream());
                                    try {
                                        // service����ΪObject��(���Է����κη���)����ֻ��ͨ��������ô�������
                                        // ������ã���������
                                        Method method = service.getClass().getMethod(methodName,
                                            parameterTypes);
                                        Object result = method.invoke(service, arguments);
                                        System.out.println("\nServer ����������Ӧ ��");
                                        System.out.println("result : " + result);
                                        output.writeObject(result);
                                    } catch (Throwable t) {
                                        output.writeObject(t);
                                    } finally {
                                        output.close();
                                    }
                                } finally {
                                    input.close();
                                }
                            } finally {
                                socket.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * ���÷���
     *
     * @param <T>            �ӿڷ���
     * @param interfaceClass �ӿ�����
     * @param host           ������������
     * @param port           �������˿�
     * @return Զ�̷��񣬷��ش������
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T refer(final Class<T> interfaceClass, final String host, final int port)
        throws Exception {
        if (interfaceClass == null) {
            throw new IllegalArgumentException("Interface class == null");
        }
        // JDK ��̬�����Լ����ֻ��ʵ�ֶԽӿڵĴ���
        if (!interfaceClass.isInterface()) {
            throw new IllegalArgumentException(
                "The " + interfaceClass.getName() + " must be interface class!");
        }
        if (host == null || host.length() == 0) {
            throw new IllegalArgumentException("Host == null!");
        }
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port " + port);
        }
        System.out.println(
            "Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);

        // JDK ��̬����
        T proxy = (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(),
            new Class<?>[] {interfaceClass}, new InvocationHandler() {
                // invoke���������Ƕ�Ŀ�귽������ǿ�����������ڷ���RPC����ͽ�����Ӧ
                @Override
                public Object invoke(Object proxy, Method method, Object[] arguments)
                    throws Throwable {
                    // ����Socket�ͻ��ˣ��������˽�������
                    Socket socket = new Socket(host, port);
                    try {
                        /* �ͻ��������˽������󣬲����������д������*/
                        // ������д�뵽����������������䷢�͵�Socket����ȥ
                        ObjectOutputStream output = new ObjectOutputStream(
                            socket.getOutputStream());
                        try {
                            // ��������
                            System.out.println("\nClient�������� �� ");
                            output.writeUTF(method.getName());
                            System.out.println("methodName : " + method.getName());
                            output.writeObject(method.getParameterTypes());
                            System.out.println("parameterTypes : " + Arrays.toString(method
                                .getParameterTypes()));
                            output.writeObject(arguments);
                            System.out.println("arguments : " + Arrays.toString(arguments));


                            /* �ͻ��˶�ȡ�����ط���˵���Ӧ*/
                            ObjectInputStream input = new ObjectInputStream(
                                socket.getInputStream());
                            try {
                                Object result = input.readObject();
                                if (result instanceof Throwable) {
                                    throw (Throwable)result;
                                }
                                System.out.println("\nClient�յ���Ӧ �� ");
                                System.out.println("result : " + result);
                                return result;
                            } finally {
                                input.close();
                            }
                        } finally {
                            output.close();
                        }
                    } finally {
                        socket.close();
                    }
                }
            });
        return proxy;
    }
}
