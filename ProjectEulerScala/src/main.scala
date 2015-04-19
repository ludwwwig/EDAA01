object main {
  def main(args: Array[String]) {
    var tree = new Tree[Integer](new Node(1))
    tree.addLevel()
    tree.addLevel()
    tree.traverse(println)
  }
}