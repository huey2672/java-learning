package com.huey.learning.java.kryo.pitfall.cyclereference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Node {

    private Long id;
    private Node prev;
    private Node next;

    public Node(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" + id + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id.equals(node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
