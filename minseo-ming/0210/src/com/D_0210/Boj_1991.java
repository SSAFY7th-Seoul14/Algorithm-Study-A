package com.D_0210;

import java.io.*;
import java.util.*;

class Node{
    char data;
    Node r_Node = null;
    Node l_Node = null;
    public Node(char data){
        this.data =data;
    }

}
class Tree{
    Node root;
    public void create(char cur, char r, char l){
        if(root==null){
            if(cur!='.')root = new Node(cur);
            if(l!='.')root.l_Node = new Node(l);
            if(r!='.')root.r_Node = new Node(r);
        }else search(root,cur,r,l);
    }
    public void search(Node parent,char cur, char r, char l){
        if(parent==null)return;
        else if(parent.data == cur){
            if(l!='.')parent.l_Node = new Node(l);
            if(r!='.')parent.r_Node = new Node(r);
        }else{
            search(parent.l_Node,cur,r,l);
            search(parent.r_Node,cur,r,l);
        }
    }
    public void pre(Node node){
        if(node == null) return;
        System.out.print(node.data);
        pre(node.l_Node);
        pre(node.r_Node);
    }
    public void post(Node node){
        if(node == null) return;
        post(node.l_Node);
        post(node.r_Node);
        System.out.print(node.data);
    }
    public void in(Node node){
        if(node == null) return;
        in(node.l_Node);
        System.out.print(node.data);
        in(node.r_Node);
    }

}

public class Boj_1991 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        for(int i=1; i<=num; i++){
            st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);
//            System.out.println(data+" "+r+" "+l );
            tree.create(data,r,l);
        }
        tree.pre(tree.root);
        System.out.println();
        tree.in(tree.root);
        System.out.println();
        tree.post(tree.root);
    }

}
