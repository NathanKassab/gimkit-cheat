# gimkit-cheat
A simple java program that automaticity clicks the correct answers for you on gimkit

# How do I use it?
1: Install firefox (I chose firefox because the chrome driver wasn't working on my pc and I didn't feel like debugging)

2: Install the gecko driver for the version of firefox that you're using (this can be found [here](https://github.com/mozilla/geckodriver/releases))

3: Place the jar from releases and the driver into the same folder

4: Run the jar, firefox should automatically start with the gimkit join game page

5: Enter code, join game and open up the question panel. The first time the program sees a question it will (most likely) get it wrong before logging the correct answer, after that the bot should answer that specific question correctly for the rest of the session

6: When you're done go into task manager and kill the java process manually (closing firefox doesn't kill the java process), I didn't make it auto close because I'm lazy and this is a quick 1 hour "for fun" project

# Why doesn't it work?
Because you don't know what you're doing, I won't tell you what went wrong or how to fix it. This repo only exists because a friend wanted me to put the code on here, not so I can help random people cheat in school games

# Should I use it?
No, the thing is a pain in the ass to setup and requires at least some technical knowledge to do so. Not to mention the thing only works on multiple choice questions, that's all my teacher used so it's all I programed for. Any question that isn't multiple choice just waits for user input (or it should, I didn't do much testing lol)

# Should I use this code in my own project?
No, the code is straight up spaghetti since I made it in less than an hour for fun. If you wish to make your own cheats I recommend you start up a test game at home and reverse engineer for a bit. Then you should code everything from scratch since this code is horrible
