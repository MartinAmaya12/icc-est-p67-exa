package controllers;
import java.util.*;
import models.Pedido;
public class PedidoController{
    
    public Stack<Maquina> filtrarPorZona(List<Pedido> pedidos, int umbral){
        Stack<Pedido> pilaRes = new Stack<>();

        for(Pedido p : pedidos){
            if(p.getSubred() < umbral){
                pilaRes.push(p);
            }
        }
        return pilaRes;
    }

    public TreeSet<Pedido> ordenarPorZona(Stack<Pedido> pila){
        Comparator<Pedido> comparador = Comparator
        .comparingInt(Pedido::getZona)
        .thenComparing(Pedido::getNombre);

        TreeSet<Pedido> arbolOrdenado = new TreeSet<>(comparador);

        while(!pila.isEmpty()){
            arbolOrdenado.add(pila.pop());
        }

        return arbolOrdenado;
    }

     public TreeMap<Integer, Queue<Pedido>> agruparPorUrgencia(List<Pedido> pedidos){
        TreeMap<Integer,    Queue<Pedido>> mapaUrgencia = new TreeMap<>();

        for(Pedido p : pedidos){
            int urgencia = p.getUrgencia();

            if(!mapaUrgencia.containsKey(urgencia)){
                mapaUrgencia.put(urgencia, new LinkedList<>());
            }

            mapaUrgencia.get(urgencia).add(p);
        }

        return mapaUrgencia;
    }

    public Stack<Pedido> explorarGrupo(Map<Integer, Queue<Pedido>> mapa){
        Queue<Pedido> grupoSeleccionado = null;
        int maxUrgencia = -1;
        int maxTamano = -1;

        for(Map.Entry<Integer, Queue<Pedido>> entrada : mapa.entrySet()){
            int urgenciaActual = entrada.getKey();
            Queue<Pedido> colaActual = entrada.getValue();

            if(colaActual.size() > maxTamano || (colaActual.size() == maxTamano && urgenciaActual > maxUrgencia)){
                maxTamano = colaActual.size();
                maxUrgencia = urgenciaActual;
                grupoSeleccionado = colaActual;
            }
        }

        Stack<Pedido> resultado  = new Stack<>();
        if(grupoSeleccionado != null){
            while(!grupoSeleccionado.isEmpty()){
                resultado.push(grupoSeleccionado.poll());
            }
        }
        return resultado;
    }
}

