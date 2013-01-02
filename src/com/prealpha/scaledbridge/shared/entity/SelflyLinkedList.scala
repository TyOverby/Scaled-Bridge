package com.prealpha.scaledbridge.shared.entity

trait SelflyLinkedList extends Iterator[SelflyLinkedList]{
    private[SelflyLinkedList]
    var nextNode: SelflyLinkedList = null

    private[SelflyLinkedList]
    var prevNode: SelflyLinkedList = null

    def hasNext = this.nextNode != null
    def next = this.nextNode

    def remove(){
        prevNode.nextNode = this.nextNode
    }

    def append(other: SelflyLinkedList){
        if (this.nextNode == null){
            this.nextNode = other
        }
        else{
            throw new UnsupportedOperationException("Attempt to add to a non-terminating linked list")
        }
    }

    /**
     * Inserts the other SelflyLinkedList into the list after this node
     * @param other
     */
    def insert(other: SelflyLinkedList){
        val prevNext = this.nextNode
        this.nextNode = other
        other.prevNode = this
        other.nextNode = prevNext
    }
}
