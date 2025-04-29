package org.example.orm_kerndl;

import org.springframework.boot.SpringApplication;

public class TestOrmKerndlApplication {

    public static void main(String[] args) {
        SpringApplication.from(OrmKerndlApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
