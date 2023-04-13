import java.util.*;

public class BinaryTree<T> {

    Node<Integer> root;

    public void add(Integer value){
        if(Objects.isNull(root)){
            root = new Node<Integer>(value);
            return;
        }

        Node<Integer> search = root;


        while(true){

            if(search.value < value){
                if(Objects.isNull(search.right)){
                    search.right = new Node<Integer>(value);
                    break;
                }
                search = search.right;
                continue;
            }

            if (Objects.isNull(search.left)){
                search.left = new Node<Integer>(value);
                break;
            }

            search = search.left;
        }
    }

    public Integer max(){

        Node<Integer> search = root;

        while (true){
            if(Objects.isNull(search.right)){
                return search.value;
            }
            search = search.right;
        }
    }

    public Integer min(){

        Node<Integer> search = root;

        while (true){
            if(Objects.isNull(search.left)){
                return search.value;
            }
            search = search.left;
        }
    }

}
