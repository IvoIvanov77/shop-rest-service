/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 30, 2019
 */
package com.example.demo.utils;


import java.util.Collection;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class DtoMapperImpl implements DtoMapper
{

    private final ModelMapper modelMapper;


    public DtoMapperImpl(ModelMapper modelMapper)
    {

        this.modelMapper = modelMapper;
    }


    @Override
    public <S, D> D map(S source, Class<D> destinationClass)
    {
        return modelMapper.map(source, destinationClass);
    }


    @Override
    public <S, D> Stream<D> map(Collection<S> sourceCollection, Class<D> destinationClass)
    {
        return sourceCollection
                .stream()
                .map(s -> map(s, destinationClass));
    }

}
