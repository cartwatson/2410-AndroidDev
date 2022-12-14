package com.usu.rougelikev2.game.gameobjects

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.usu.rougelikev2.game.gameengine.Game
import com.usu.rougelikev2.game.gameengine.GameObject
import com.usu.rougelikev2.game.gameengine.Location
import java.util.*
import kotlin.math.roundToInt


class BossMonster(game: Game?) : GameObject(game!!) {
    var pattern: ArrayList<Int>? = null
    var turnNumber = 0
    override fun update(elapsedTime: Long) {
        if (pattern == null) {
            pattern = ArrayList()
            pattern!!.add(0)
            pattern!!.add(1)
            for (i in 0 until state.get("level")) {
                val move = Math.random().roundToInt()
                pattern!!.add(move)
            }
        }
        val isAlive = state.get<Boolean>("alive")
        val turn = game.gameState.get<String>("turn")
        if (turn !== "monster") return
        game.gameState["endTurn"] = true
        if (!isAlive) return
        val action = pattern!![turnNumber % pattern!!.size]
        if (action == 1) { // move
            turnNumber++
            val map = game.gameState.get<Array<Array<GameObject?>>>("map")
            if (checkForPlayer()) {
                val player = game.getGameObjectWithTag("player")
                val playerLocation: Location = player!!.state["coords"]
                val myLocation: Location = state["coords"]
                if (myLocation.x != playerLocation.x && myLocation.y != playerLocation.y) {
                    if (myLocation.y < playerLocation.y) {
                        val other = map[myLocation.y.toInt() + 1][myLocation.x.toInt()]
                        if (other == null) {
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = null
                            myLocation.y = myLocation.y + 1
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = this
                            return
                        }
                    }
                    if (myLocation.y > playerLocation.y) {
                        val other = map[myLocation.y.toInt() - 1][myLocation.x.toInt()]
                        if (other == null) {
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = null
                            myLocation.y = myLocation.y - 1
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = this
                            return
                        }
                    }
                    if (myLocation.x < playerLocation.x) {
                        val other = map[myLocation.y.toInt()][myLocation.x.toInt() + 1]
                        if (other == null) {
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = null
                            myLocation.x = myLocation.x + 1
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = this
                            return
                        }
                    }
                    if (myLocation.x > playerLocation.x) {
                        val other = map[myLocation.y.toInt()][myLocation.x.toInt()]
                        if (other == null) {
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = null
                            myLocation.x = myLocation.x - 1
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = this
                            return
                        }
                    }
                    moveRandom()
                } else if (myLocation.x == playerLocation.x) { // same column
                    if (myLocation.y < playerLocation.y) {
                        val other = map[myLocation.y.toInt()][myLocation.x.toInt()]
                        if (other is Player) {
                            // end the game
                            other.state["alive"] = false
                            game.gameState["playing"] = false
                            return
                        } else if (other == null) {
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = null
                            myLocation.y = myLocation.y + 1
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = this
                            return
                        }
                    }
                    if (myLocation.y > playerLocation.y) {
                        val other = map[myLocation.y.toInt() - 1][myLocation.x.toInt()]
                        if (other is Player) {
                            // end the game
                            other.state["alive"] = false
                            game.gameState["playing"] = false
                            return
                        } else if (other == null) {
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = null
                            myLocation.y = myLocation.y - 1
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = this
                            return
                        }
                    }
                    moveRandom()
                } else if (myLocation.y == playerLocation.y) { // same row
                    if (myLocation.x < playerLocation.x) {
                        val other = map[myLocation.y.toInt()][myLocation.x.toInt() + 1]
                        if (other is Player) {
                            // end the game
                            other.state["alive"] = false
                            game.gameState["playing"] = false
                            return
                        } else if (other == null) {
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = null
                            myLocation.x = myLocation.x + 1
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = this
                            return
                        }
                    }
                    if (myLocation.x > playerLocation.x) {
                        val other = map[myLocation.y.toInt()][myLocation.x.toInt() - 1]
                        if (other is Player) {
                            // end the game
                            other.state["alive"] = false
                            game.gameState["playing"] = false
                            return
                        } else if (other == null) {
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = null
                            myLocation.x = myLocation.x - 1
                            map[myLocation.y.toInt()][myLocation.x.toInt()] = this
                            return
                        }
                    }
                    moveRandom()
                }
            } else {
                moveRandom()
            }
        } else {
            turnNumber++
        }
    }

    private fun moveRandom() {
        val neighbors = mutableListOf<Int>()
        neighbors.add(1)
        neighbors.add(2)
        neighbors.add(3)
        neighbors.add(4)
        neighbors.shuffle()
        val map = game.gameState.get<Array<Array<GameObject?>>>("map")
        val myLocation: Location = state.get("coords")
        while (neighbors.isNotEmpty()) {
            val `val` = neighbors.removeAt(0)
            if (`val` == 1) {
                if (myLocation.y > 0 && map[myLocation.y.toInt() - 1][myLocation.x.toInt()] == null) {
                    map[myLocation.y.toInt() - 1][myLocation.x.toInt()] = this
                    map[myLocation.y.toInt()][myLocation.x.toInt()] = null
                    myLocation.y = myLocation.y - 1
                    return
                }
            }
            if (`val` == 2) {
                if (myLocation.x < map[0].size - 1 && map[myLocation.y.toInt()][myLocation.x.toInt() + 1] == null) {
                    map[myLocation.y.toInt()][myLocation.x.toInt() + 1] = this
                    map[myLocation.y.toInt()][myLocation.x.toInt()] = null
                    myLocation.x = myLocation.x + 1
                    return
                }
            }
            if (`val` == 3) {
                if (myLocation.y < map.size - 1 && map[myLocation.y.toInt() + 1][myLocation.x.toInt()] == null) {
                    map[myLocation.y.toInt() + 1][myLocation.x.toInt()] = this
                    map[myLocation.y.toInt()][myLocation.x.toInt()] = null
                    myLocation.y = myLocation.y + 1
                    return
                }
            }
            if (`val` == 4) {
                if (myLocation.x > 0 && map[myLocation.y.toInt()][myLocation.x.toInt() - 1] == null) {
                    map[myLocation.y.toInt()][myLocation.x.toInt() - 1] = this
                    map[myLocation.y.toInt()][myLocation.x.toInt()] = null
                    myLocation.x = myLocation.x - 1
                    return
                }
            }
        }
    }

    private fun checkForPlayer(): Boolean {
        val player = game.getGameObjectWithTag("player")
        val playerLocation: Location = player!!.state.get("coords")
        val myLocation: Location = state.get("coords")
        val distance = Math.sqrt(
            Math.pow(
                (playerLocation.x - myLocation.x).toDouble(),
                2.0
            ) + Math.pow((playerLocation.y - myLocation.y).toDouble(), 2.0)
        )
        return distance < 5
    }

    override fun render(canvas: Canvas, paint: Paint) {
//        things you can do in this render method for reference.
//        val coords: Location = state["coords"] // gets the location of the object in the grid
//        val cellSize: Int = game.gameState["cellSize"] // gets the size of each cell in the game
//        val myX = coords.x * cellSize // gets the current x position (in pixels) in screen space
//        val myY = coords.y * cellSize // gets the current y position (in pixels) in screen space
//        val alive: Boolean = state["alive"] // get whether or not the monster is alive
//        val level: Int = state["level"]; // gets the difficulty level of the monster
//        val health: Int = state["health"]; // gets how much health the monster has left
        val coords: Location = state["coords"]
        val cellSize: Int = game.gameState["cellSize"]
        val myX = coords.x * cellSize
        val myY = coords.y * cellSize
        val alive: Boolean = state["alive"]
        canvas.translate(myX, myY)
        val size = cellSize.toFloat()

        if (alive) {
            // body
            paint.color = Color.rgb(80,80,80)
            canvas.drawCircle(size/2, size/2, 60f, paint)
            paint.color = Color.rgb(0,0, 255)
            canvas.drawCircle(size/2, size/2, 58f, paint)
            paint.color = Color.rgb(0, 0, 126)
            canvas.drawOval(30f, size-80f, size-30f, size-25f, paint)
            // eyes
            paint.color = Color.rgb(0,0,0)
            canvas.drawOval(size/2-30f, 40f, size/2-10f, size/2+10f, paint)
            canvas.drawOval(size/2+30f, 40f, size/2+10f, size/2+10f, paint)
        } else {
            // body
            paint.color = Color.rgb(80,80,80)
            canvas.drawCircle(size/2, size/2, 60f, paint)
            paint.color = Color.rgb(0,0,0)
            canvas.drawCircle(size/2, size/2, 58f, paint)
            paint.color = Color.rgb(0, 0, 0)
            canvas.drawOval(30f, size-80f, size-30f, size-25f, paint)
            // eyes
            paint.color = Color.rgb(0,0,255)
            canvas.drawOval(size/2-30f, 40f, size/2-10f, size/2+10f, paint)
            canvas.drawOval(size/2+30f, 40f, size/2+10f, size/2+10f, paint)
        }
    }

    init {
        state["alive"] = true
        state["health"] = 6
        state["level"] = 1 // will be overridden by game after instantiation
    }
}