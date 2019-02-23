#!/usr/bin/python
# -*- coding: UTF-8 -*-

import xlrd

data = xlrd.open_workbook('D:\\tb_item.xls')

#获取一个工作表
table = data.sheet_by_index(0)

#返回一个数组
row1 = table.row_values(1)


print(row1)

