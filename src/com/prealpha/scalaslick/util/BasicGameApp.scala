package com.prealpha.scalaslick.util



import org.newdawn.slick.{AppGameContainer, BasicGame}

// -Djava.library.path=lib/windows
abstract class BasicGameApp(title: String) extends BasicGame(title){

    def main(args: Array[String]){
        val app = new AppGameContainer(this)
        app.setDisplayMode(800,600,false)
        app.start()
    }
}