# Итоговая контрольная работа
## Информация о проекте
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.
## Как сдавать проект
Для сдачи проекта необходимо создать отдельный общедоступный
репозиторий(Github, gitlub, или Bitbucket). Разработку вести в этом
репозитории, использовать пул реквесты на изменения. Программа должна
запускаться и работать, ошибок при выполнении программы быть не должно.
Программа, может использоваться в различных системах, поэтому необходимо
разработать класс в виде конструктора


### Задание
1. Используя команду cat в терминале операционной системы Linux, создать
   два файла Домашние животные (заполнив файл собаками, кошками,
   хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
   ослы), а затем объединить их. Просмотреть содержимое созданного файла.
   Переименовать файл, дав ему новое имя (Друзья человека).

      #### cat > pets.txt
   Собака  
   Кошка  
   Хомяк
      #### cat > pack_animals.txt
   Лошадь  
   Верблюд  
   Осел

      #### cat pets.txt pack_animals.txt > animals.txt
      #### cat animals.txt
   Собака  
   Кошка  
   Хомяк  
   Лошадь  
   Верблюд  
   Осел  
      #### mv animals.txt human_friends.txt
2. Создать директорию, переместить файл туда.
      #### mkdir animal
      #### mv human_friends.txt animal/
3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
   из этого репозитория.
      #### sudo dpkg -i mysql-apt-config_0.8.25-1_all.deb
      #### sudo apt install mysql-server mysql-client
4. Установить и удалить deb-пакет с помощью dpkg.
      #### sudo wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
      #### sudo dpkg -i --force-depends google-chrome-stable_current_amd64.deb
      #### sudo dpkg -r google-chrome-stable
5. Выложить историю команд в терминале ubuntu
      

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
   животные и вьючные животные, в составы которых в случае домашних
   животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
   войдут: Лошади, верблюды и ослы).

![UML diagram for the animals class](img/uml_animal1.png)

7. В подключенном MySQL репозитории создать базу данных “Друзья
   человека”
      #### mysql> CREATE DATABASE human_friends;
      #### mysql> USE human_friends;
8. Создать таблицы с иерархией из диаграммы в БД  
       CREATE TABLE animal_class (  
   &nbsp; &nbsp; &nbsp; id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,  
   &nbsp; &nbsp; &nbsp; name VARCHAR(30) NOT NULL  
);  
       CREATE TABLE animal_genus (  
   &nbsp; &nbsp; &nbsp; id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,   
   &nbsp; &nbsp; &nbsp; name VARCHAR(30) NOT NULL,  
   &nbsp; &nbsp; &nbsp; class_id INT,  
   &nbsp; &nbsp; &nbsp; FOREIGN KEY (class_id) REFERENCES animal_class (id) ON DELETE CASCADE ON UPDATE CASCADE  
);  
       CREATE TABLE animal (  
   &nbsp; &nbsp; &nbsp; id INT AUTO_INCREMENT PRIMARY KEY,  
   &nbsp; &nbsp; &nbsp; name VARCHAR(30) NOT NULL,  
   &nbsp; &nbsp; &nbsp; birthday DATE,  
   &nbsp; &nbsp; &nbsp; genus_id INT,  
   &nbsp; &nbsp; &nbsp; FOREIGN KEY (genus_id) REFERENCES animal_genus (id) ON DELETE CASCADE ON UPDATE CASCADE  
);  
       CREATE TABLE command (  
   &nbsp; &nbsp; &nbsp; id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,  
   &nbsp; &nbsp; &nbsp; name VARCHAR(30) NOT NULL,  
   &nbsp; &nbsp; &nbsp; description VARCHAR(300) NOT NULL  
);  
   CREATE TABLE animal_command (  
   &nbsp; &nbsp; &nbsp; animal_id INT NOT NULL,  
   &nbsp; &nbsp; &nbsp; command_id INT NOT NULL,  
   &nbsp; &nbsp; &nbsp; FOREIGN KEY (animal_id) REFERENCES animal (id) ON DELETE CASCADE ON UPDATE CASCADE,  
   &nbsp; &nbsp; &nbsp; FOREIGN KEY (command_id) REFERENCES command (id) ON DELETE CASCADE ON UPDATE CASCADE  
);




   
