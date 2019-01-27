#!/usr/bin/env python3
# -*- coding: utf-8 -*-
#一定要用tab键，否则报错！！
from email import encoders
from email.header import Header
from email.mime.text import MIMEText
from email.utils import parseaddr, formataddr

import smtplib



def _format_addr(s):
	name,addr=parseaddr(s);
		return formataddr((Header(name, 'utf-8').encode(), addr))

from_addr = imput('From: ')
password = input('Password: ')
to_addr = input('To: ')
smtp_server = input('SMTP server: ')



