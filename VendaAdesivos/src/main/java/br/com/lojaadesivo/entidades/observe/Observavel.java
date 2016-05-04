
package br.com.lojaadesivo.entidades.observe;

/**
 *
 * @author Aluísio
 * @param <T>
 */
public interface Observavel<T> {
      /**
     * Método adiciona observador
     *
     * @param newObserver
     */
    void addObserver(Observador newObserver);
      /**
     * Método remover observador
     *
     * @param observer
     */
    void removeObserver(Observador observer);
      /**
     * Método notifica oservador
     *
     * @param object
     */
    void notifyObservers(T object);
    
}