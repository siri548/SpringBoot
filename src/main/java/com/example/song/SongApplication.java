// Do not modify code in this file

package com.example.song;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages="com.example.song")
public class SongApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongApplication.class, args);
	}

}
