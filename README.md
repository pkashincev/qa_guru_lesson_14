# Проект по автоматизации тестирования для компании [Росаква](https://xn--80aaf5asli.xn--p1acf/)

> Росаква — компания являющаяся производителем бутилированной воды и оказывающая услуги по доставке свежей воды домой и в офис.

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
____
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center"> 
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a> 
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a> 
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a> 
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a> 
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> 
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a> 
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> 
<a href="https://github.com/allure-framework/"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="images/logo/Allure2.svg" width="50" height="50"  alt="Allure TestOps"/></a>  
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> 
<a href="https://www.atlassian.com/ru/software/jira/"><img src="images/logo/Jira.svg" width="50" height="50"  alt="Jira"/></a> 
</p>

____
<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>
____
- ✓ *Успешная авторизация и вход в аккаунт*
- ✓ *Неуспешная авторизация*
- ✓ *Выход из аккаунта*
- ✓ *Поиск товаров*
- ✓ *Добавление товара в корзину*
- ✓ *Удаление товара из корзины*
- ✓ *Добавление товара в избранное*
- ✓ *Удаление товара из избранного*


____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/032-PavelKashintsev-qa_guru_lesson_14/)</a>
____
<p align="center"> 
<a href="https://jenkins.autotests.cloud/job/032-PavelKashintsev-qa_guru_lesson_14/"><img src="images/screen/jenkins_build.png" alt="Jenkins" width="950"/></a> 
</p>


### **Параметры сборки в Jenkins:**

- *BASE_URL (адрес тестируемого веб-сайта)*
- *SELENOID_URL (адрес удаленного сервера Selenoid)*
- *BROWSER (браузер, по умолчанию chrome)*
- *BROWSER_VERSION (версия браузера, по умолчанию 127.0)*
- *BROWSER_SIZE (размер окна браузера, по умолчанию 1920x1080)*
- *LOGIN (логин для авторизации на тестируемом сайте)*
- *PASSWORD (пароль для авторизации на тестируемом сайте)*
- *SELENOID_LOGIN (логин для для удаленного сервера Selenoid)*
- *SELENOID_PASSWORD (пароль для для удаленного сервера Selenoid)*

<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск c параметрами из local.properties:***
```bash 
gradle clean test
```

***Удалённый запуск с использованием Selenoid с параметрами из remote.properties:***
```bash 
gradle clean test "-Denv=remote"
```
___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/032-PavelKashintsev-qa_guru_lesson_14/allure/)</a>
___

### *Основная страница отчёта*

<p align="center"> 
<img title="Allure Overview Dashboard" src="images/screen/jenkins.png" width="850"> 
</p> 

### *Тест-кейсы*

<p align="center"> 
<img title="Allure Tests" src="images/screen/jenkins_tests.png" width="850"> 
</p>

### *Графики*

  <p align="center"> 
<img title="Allure Graphics" src="images/screen/allure_graph1.png" width="850">

<img title="Allure Graphics" src="images/screen/allure_graph2.png" width="850"> 
</p>

___
<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="images/logo/Allure2.svg" width="25"/></a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/4739/dashboards">Allure TestOps</a>
____
### *Allure TestOps Dashboard*

<p align="center"> 
<img title="Allure TestOps Dashboard" src="images/screen/allure_overview.png" width="850"> 
</p>

### *Авто тест-кейсы*

<p align="center"> 
<img title="Allure TestOps Tests" src="images/screen/allure_autotestsN.png" width="850"> 
</p>

___
<a id="jira"></a>
## <img alt="Allure" height="25" src="images/logo/Jira.svg" width="25"/></a> Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1445">Jira</a>
____
<p align="center"> 
<img title="Jira" src="images/screen/jira.png" width="850"> 
</p>

____
<a id="telegram"></a>
## <img alt="Allure" height="25" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center"> 
<img title="Allure Overview Dashboard" src="images/screen/telegram.png" width="550"> 
</p>

____
<a id="video"></a>
## <img alt="Selenoid" height="25" src="images/logo/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid
____
<p align="center">
<img title="Selenoid Video" src="images/video/sample_video.gif" width="550" height="350"  alt="video">  
</p>