package fr.uga.pddl4j.tutorial.asp;

import fr.uga.pddl4j.util.BitState;

/**
 * This class implements a node of the tree search.
 *
 * @author D. Pellier
 * @version 1.0 - 06.06.2018
 */
public final class Node extends BitState {

    private BitState state;
    private Node parent;
    private int operator;
    private int cost;
    private int heuristic;

    /**
    * Creates a new node from a specified state.
    *
    * @param state the state.
    */
    public Node(BitState state) {
        super(state);
    }

    /**
    * Creates a new node with a specified state, parent node, operator, cost and
    * heuristic value.
    *
    * @param state     the logical state of the node.
    * @param parent    the parent node of the node.
    * @param operator  the operator applied to reached the node from its parent.
    * @param cost      the cost to reach the node from the root node.
    * @param heuristic the estimated distance to reach the goal from the node.
    */
    public Node(BitState state, Node parent, int operator, int cost, int heuristic) {
        super(state);
        this.parent = parent;
        this.operator = operator;
        this.cost = cost;
        this.heuristic = heuristic;
    }

    //Getter
    public int getHeuristic(){
        return this.heuristic;
    }

    public BitState getState(){
        return this.state;
    }

    public Node getParent(){
        return this.parent;
    }
    public int getOperator(){
        return this.operator;
    }
    public int getCost(){
        return this.cost;
    }

    //Setter 
    public void setHeuristic(int h){
        this.heuristic = h;
    }

    public void setState(BitState s){
        this.state=s;
    }

    public void setParent(Node p){
        this.parent=p;
    }

    public void setCost(int c){
        this.cost=c;
    }

    public void setOperator(int o){
        this.operator=o;
    }
    // To complete

}