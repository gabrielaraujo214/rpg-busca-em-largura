package com.example;

import java.util.*;

class Grafo {
    private Map<Integer, List<Integer>> adjacencias;

    // Construtor do Grafo
    public Grafo() {
        adjacencias = new HashMap<>();
    }

    // Adicionar um vértice ao grafo
    public void adicionarVertice(int v) {
        adjacencias.putIfAbsent(v, new ArrayList<>());
    }

    // Adicionar uma aresta entre v1 e v2 (grafo não direcionado)
    public void adicionarAresta(int v1, int v2) {
        adjacencias.get(v1).add(v2);
        adjacencias.get(v2).add(v1); // Para um grafo não direcionado
    }

    // Função BFS
    public List<Integer> bfs(int inicio) {
        List<Integer> resultado = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> fila = new LinkedList<>();

        // Começa com o vértice inicial
        fila.offer(inicio);
        visitados.add(inicio);

        while (!fila.isEmpty()) {
            int v = fila.poll();
            resultado.add(v);

            // Para cada vizinho do vértice v
            for (int vizinho : adjacencias.get(v)) {
                if (!visitados.contains(vizinho)) {
                    visitados.add(vizinho);
                    fila.offer(vizinho);
                }
            }
        }
        return resultado; // Retorna a ordem de visitação
    }

    // Função para imprimir o grafo
    public void imprimirGrafo() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencias.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (int vizinho : entry.getValue()) {
                System.out.print(vizinho + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Adicionando vértices
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);
        grafo.adicionarVertice(5);

        // Adicionando arestas
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 4);
        grafo.adicionarAresta(3, 5);

        // Imprimir o grafo
        System.out.println("Grafo:");
        grafo.imprimirGrafo();

        // Realizando a BFS a partir do vértice 1
        System.out.println("\nOrdem de visitaçao (BFS) a partir do vértice 1:");
        List<Integer> ordemBFS = grafo.bfs(1);
        System.out.println(ordemBFS);
    }
}
