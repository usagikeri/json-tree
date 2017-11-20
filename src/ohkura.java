/**
 * Created by shinya on 2017/11/20.
 */

import ohkura.Child;

public class ohkura{
    public static void main(String args[]) {
        Child c1 = new Child("Parent_url", "Parent_mime", "Parent_source");
        Child c2 = c1.add_child("Child_url","Child_mime","Child_source");

        System.out.println(c1.json_tree());
    }
}
