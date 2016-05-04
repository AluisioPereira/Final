package br.com.lojaadesivo.entidades.observe;

/**
 *
 * @author Aluísio
 * @param <T>
 */
public interface Observador<T> {

    /**
     * Método busca dado atributo da classe a ser retornado
     *
     * @param object
     */
    void update(T object);

}
