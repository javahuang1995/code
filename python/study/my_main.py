#!/usr/bin/env python3
# -*- coding: utf-8 -*-
#一定要用tab键，否则报错！！

'a test module'

from com.huang.myObject import *

__author__='HandsomeHuang'

import sys

def test():
	args = sys.argv
	if len(args)==1:
		print('Hello, world!')
	elif len(args)==2:
		print('Hello, %s!' % args[1])
	else:
		print('Too many arguments!')

def test2():
	pp=Person(2,3,4);
	print(pp.weight+pp.hight+pp.age)


if __name__=='__main__':
    test()