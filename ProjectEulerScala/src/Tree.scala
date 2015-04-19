class Tree[E](root: Node[E] = null) {
  def traverse(fun:(E) => Unit) {
    root.traverse(fun) 
  }
  
  def addLevel() {
    if(root != null) {
      root.traverse(root.addChildren)
    }
  }
}

class Node[E](content: E, leftChild: Node[E] = null, rightChild: Node[E] = null) {
   var data: E = content
   var left: Node[E] = leftChild
   var right: Node[E] = rightChild
   
   def addChildren(element: E) {
     if(left == null) {
       left = new Node[E](element)
     } else {
       left.addChildren(element)
     }
     if(right == null) {
       right = new Node[E](element)
     } else {
       right.addChildren(element)
     }
   }
   
   def traverse(fun:E => Unit) {
     if(left != null) {
       left.traverse(fun)
       }
     if(right != null) {
       right.traverse(fun)
     }
     if(data != null) {
       fun(data)
     }
   }
}