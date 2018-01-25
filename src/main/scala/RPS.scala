object RPS {

  def main (args:Array[String]): Unit ={
    playerMove()
  }
  def pickWinner(move1:String, move2:String)=(move1,move2) match {
    case (a,b)if a.equalsIgnoreCase("rock") && b.equalsIgnoreCase("scissors") || a.equalsIgnoreCase("paper") && b.equalsIgnoreCase("rock") || a.equalsIgnoreCase("scissors") && b.equalsIgnoreCase("paper")=> "Player one wins"
    case (a,b)if b.equalsIgnoreCase("rock") && a.equalsIgnoreCase("scissors") || b.equalsIgnoreCase("paper") && a.equalsIgnoreCase("rock") || b.equalsIgnoreCase("scissors") && a.equalsIgnoreCase("paper")=> "Player Two wins"
    case(a,_)if a.equalsIgnoreCase("exit") => "That's it you run away!"
    case (_,_) => "Tie"
  }
  def aiBias(): Boolean ={

    val value = scala.util.Random
    if ((randomNumber+2) == 3) return true
    return false
  }
  def randomNumber(): Int ={
    val value = scala.util.Random
    value.nextInt(2)
  }
  def moves(input:Int) = (input)match{
    case(a) if a == 0 => "paper"
    case(a) if a == 1 => "scissors"
    case(a) if a == 2 => "rock"


  }
  def aiMove(rockCount:Int, paperCount:Int, scissorsCount:Int, bias:Boolean) = (rockCount, paperCount, scissorsCount, bias) match{
    case(_,_,_,false)=> moves(randomNumber())
    case(a,b,c,true) if a > b && a > c => moves(0)
    case(a,b,c,true) if  b > a && b > c => moves(1)
    case(a,b,c,true) if c > a && c > b => moves(2)
    case(_,_,_,true) => moves(randomNumber())
  }
  def playerMove (): Unit ={

    var rockCount = 0
    var paperCount = 0
    var scissorCount =0
    var running = true
    while (running) {
      var input = readInput
      println(pickWinner(input, aiMove(rockCount, paperCount, scissorCount,aiBias())))
      if (input.equalsIgnoreCase("rock")) rockCount += 1
      if (input.equalsIgnoreCase("paper")) paperCount += 1
      if (input.equalsIgnoreCase("scissors")) scissorCount += 1
      if (input.equalsIgnoreCase("exit")) running = false
      println(rockCount+" "+paperCount+" "+scissorCount)
    }
  }

  def readInput: String ={
    scala.io.StdIn.readLine()
  }
}
