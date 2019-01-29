package com.huang.annotation.test;
import java.lang.reflect.Field;


/**
 * UserCheck.java
 * ע�������
 * @author IT�Ʋ��� 2014��7��11��
 */
public class UserCheck
{
    public static boolean check(User user)
    {
        if (user == null)
        {
            System.out.println("����У�����Ϊ�գ���");
            return false;
        }

        // ��ȡUser����������ԣ����ʹ��getFields�����޷���ȡ��private�����ԣ�
        Field[] fields = User.class.getDeclaredFields();

        for (Field field : fields)
        {
            // ���������ע�⣬�ͽ���У��
            if (field.isAnnotationPresent(Validate.class))
            {
                Validate validate = field.getAnnotation(Validate.class);
                if (field.getName().equals("age"))
                {
                    if (user.getAge() == null)
                    {
                        if (validate.isNotNull())
                        {
                            System.out.println("��������ɿ�У�鲻ͨ��������Ϊ�գ���");
                            return false;
                        }
                        else
                        {
                            System.out.println("����ɿ�У��ͨ��������Ϊ��");
                            continue;
                        }
                    }
                    else
                    {
                        System.out.println("����ɿ�У��ͨ��");
                    }

                    if (user.getAge().length() < validate.min())//validate.min()��ȡMinֵ
                    {
                        System.out.println("����������С����У�鲻ͨ������");
                        return false;
                    }
                    else
                    {
                        System.out.println("������С����У��ͨ��");
                    }

                    if (user.getAge().length() > validate.max())//validate.max()��ȡmaxֵ
                    {
                        System.out.println("����������󳤶�У�鲻ͨ������");
                        return false;
                    }
                    else
                    {
                        System.out.println("������󳤶�У��ͨ��");
                    }
                }
                if (field.getName().equals("name"))
                {
                    if (user.getName() == null)
                    {
                        if (validate.isNotNull())//validate.isNotNull() ��ȡ�Ƿ����Ϊ��
                        {
                            System.out.println("�������ֿɿ�У�鲻ͨ��������Ϊ�գ���");
                            return false;
                        }
                        else
                        {
                            System.out.println("���ֿɿ�У��ͨ��������Ϊ��");
                            continue;
                        }
                    }
                    else
                    {
                        System.out.println("���ֿɿ�У��ͨ��");
                    }

                    if (user.getName().length() < validate.min())
                    {
                        System.out.println("����������С����У�鲻ͨ������");
                        return false;
                    }
                    else
                    {
                        System.out.println("������С����У��ͨ��");
                    }

                    if (user.getName().length() > validate.max())
                    {
                        System.out.println("����������󳤶�У�鲻ͨ������");
                        return false;
                    }
                    else
                    {
                        System.out.println("������󳤶�У��ͨ��");
                    }
                }
            }
        }

        return true;
    }
}