import java.util.*;
public class MyLL<AnyType>implements Iterable<AnyType>{
   private Node<AnyType> head;
   public void MyLL(){
    head = null;
    }
    public void addFirst(AnyType item){
       head = new Node<AnyType> (item,head);
       }
       private class Node<AnyType>{
          private AnyType data;
          private Node<AnyType> next;
          public Node(AnyType data, Node<AnyType>next){
            this.data = data;
            this.next = next;
            }
            }
             public Iterator<AnyType> iterator(){
                return new LLIterator();
                }
          private class LLIterator implements Iterator<AnyType>{
          public Node<AnyType>nextNode;
          public LLIterator(){
          nextNode = head;
          }
          public boolean hasNext(){
          return nextNode != null;
          }
          public AnyType next(){
          if(!hasNext()){
          throw new NoSuchElementException();
          }
          AnyType res = nextNode.data;
          nextNode = nextNode.next;
          return res;
          }
          }
          }
          