package com.gql.gqldemo.services;

import com.gql.gqldemo.repositories.CoureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphQLService {

    @Autowired
    CoureRepository coureRepository;


}
