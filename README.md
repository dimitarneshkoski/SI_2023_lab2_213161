# Втора лабораториска вежба по Софтверско инженерство
#
## Димитар Нешкоски, индекс 213161
#
## Control Flow Graph

![CFG_GRAPH_SLIKA_SIlab2](https://github.com/dimitarneshkoski/SI_2023_lab2_213161/assets/108578641/d2db0d9d-dba5-4c8a-a73e-e8849b6d62ad)
#
#
## Цикломатска комплексност

   Цикломатската комплексност на кодот е 11, а истата беше пресметана на 2 начина, преку броење на регионите од CFG графот плус 1 (10 + 1), како и преку формулата V(G)=E–N+2 односно 31(ребра)-22(јазли)+2 = 11.
 #
 #
 
## Тест случаи според критериумот Every Branch

##### testcase1: user.getPassword() == null; allUsers == whathever(T or F);

Passed edges: 1-2, 2-18;
#
##### testcase2: user.username = "username", user.email = FAIL,  user.pass = "223305", list = [Username2];

Passed edges: 1-3, 3-5, 5-11, 11-13, 13-14.1, 14.1-14.2, (14.2-15, 15-14.3, 14.3-14.2) 14.2-17, 17-18;
#
##### testcase3: user.username == null, user.pass == "010101", user.email = "email@smth.com", list = [sameAs, unique, unique];

Passed edges: 1-3, 3-4, 4-5, 5-6.1, 6.1-6.2, (6.2-7, 7-9, 9-6.3, 6.3-6.2), 6.2-7, 7-8, 8-9, 9-10, 10-6.3, 6.3-6.2, 6.2-11, 11-12, 12-18;
#
##### testcase4: user.username = "Dimitar", user.password = "empty1 2space", list = [] empty;

Passed edges: 1-3, 3-5, 5-11, 11-13, 13-17, 17-18;
#
##### testcase5: user.username = "Dimitar2", user.password = "special%&'()\*+,-./:;<Pass123", user.email = "emailNoRegex", empty List allUsers = [];

Passed edges: 1-3, 3-5, 5-11, 11-13, 13-14.1, 14.1-14.2, (14.2-15, 15-14.3, 14.3-14.2), 14.2-15, 15-16, 16-18;

#
#

## Тест случаи според критериумот Multiple Condition за условот "if (user==null || user.getPassword()==null || user.getEmail()==null);"

##### testcase1: True, Anything (T or F) Password, Anything (T or F) Email;
      user == null, (user.password == null || user.password != null), (user.email == null || user.email != null);

##### testcase2: FALSE (F) User, TRUE (T) Password, Anything (T or F) Email;
      user != null, user.password == null, (user.email == null || user.email != null);

##### testcase3: FALSE (F) User, FALSE (F) Password, TRUE (T) Email;
      user != null, user.password != null && user.email == null;
      
##### testcase4 FALSE (F) User, FALSE (F) Password, FALSE (F) Email;      
      user != null, user.password != null && user.email != null;
