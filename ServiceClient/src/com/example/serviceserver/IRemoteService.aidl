package com.example.serviceserver;

import com.example.serviceserver.Person;

interface IRemoteService { 
        void savePersonInfo(in Person person); 
        List<Person> getAllPerson(); 
}