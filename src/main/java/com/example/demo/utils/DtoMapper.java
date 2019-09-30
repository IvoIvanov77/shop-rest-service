/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 30, 2019
 */
package com.example.demo.utils;

import java.util.Collection;
import java.util.stream.Stream;

public interface DtoMapper
{
    
    public  <S, D> D map(S source, Class<D> destinationClass);

    public  <S, D> Stream<D> map(Collection<S> sourceCollection, Class<D> destinationClass);

}
