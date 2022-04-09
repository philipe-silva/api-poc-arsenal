package br.com.poc.arsenal.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArsenalModel {

    private @Id
    @GeneratedValue
    Long id;
    protected String name;

}
