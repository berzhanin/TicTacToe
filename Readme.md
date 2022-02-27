# The game 'Tic-Tac-Toe' - Backend Spring Boot REST API
The computer game 'Tic-Tac-Toe' is such as a paper-and-pencil game for two players who take turns marking the spaces in
a three-by-three grid with X or O.
The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row is the winner.
It is a solved game, with a forced draw assuming best play from both players.

# Gameplay
Tic-tac-toe is played on a three-by-three grid by two players, who alternately place the marks X and O in one of the nine spaces in the grid.

# Rules for tic-tac-toe
1. The game is played on a grid that's 3 squares by 3 squares.
2. You are X, your friend (or the computer in this case) is O. Players take turns putting their marks in empty squares.
3. The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.
4. When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.

# Strategy
To beat the computer (or at least tie), you need to make use of a little bit of strategy. Strategy means figuring out
what you need to do to win. Part of your strategy is trying to figure out how to get three Xs in a row.
The other part is trying to figure out how to stop the computer from getting three Os in a row.
After you put an X in a square, you start looking ahead. Where's the best place for your next X?
You look at the empty squares and decide which ones are good choices—which ones might let you make three Xs in a row.
You also have to watch where the computer puts its O. That could change what you do next.
If the computer gets two Os in a row, you have to put your next X in the last empty square in that row, or the computer will win.
You are forced to play in a particular square or lose the game.
If you always pay attention and look ahead, you'll never lose a game of Tic-Tac-Toe. You may not win, but at least you'll tie.

# Services
3 сервиса
user-service - регистрация/авторизация пользователей, список пользователей
battle-service - пользователь может начать новую битву(настройка игрового поля) , просмотреть список открытых битв, вступить в битву, логика биты, история ходов
statistic-service - рейтинг пользователей

# Stack
Java 11,Gradle, Spring boot, spring oauth, REST, java core, Docker, mysql, git hub
Mono repo

# Plan
1. Создание репозитория
2. Настройка gradle проекта с 3мя пустыми сервисами
3. создание сервиса user-service
   Разработка моделей/интерфейсов
   REST-API
   4 Создание сервиса battle-service
   Разработка моделей/интерфейсов
   REST-API
5. Создание Сервиса statistic-service
   Разработка моделей/интерфейсов
   REST-API

6. Имплементация REST API  моделей для user-service. Подключить базу, написать логику регистрации
7. Имплементация REST API  моделей для battle-service. Подключить базу, написать логику создания битвы, написать логику поиска битвы, написать логику игрового процесса. Логика сохранения статистика в statistic-service должна быть замочена на  этом этапе.
8. Запуск и тестирование 2х сервисов
9. Запаковать 2 сервиса в  Docker
10. Тестирование приложения в докер контейнерах
11. ......

# Gradle

* List all projects under gradle project
```$ gradle -q projects```

* Build and create docker images for all project from parent
```$ gradle clean build bootBuildImage```

* Execute gradle task on specific project from parent

```
$ gradle clean :user-service:bootRun

$ gradle clean :user-service:build :user-service:bootBuildImage
```

# Test service via cURL 

```$ curl http://localhost:8081/greeting```

```$ curl http://localhost:8082/greeting```

```$ curl http://localhost:8083/greeting```