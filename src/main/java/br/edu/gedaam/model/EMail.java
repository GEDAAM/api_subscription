package br.edu.gedaam.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EMail  implements Serializable {
    private String from;
    private List<String> to;
    private String subject;
    private String text;

    public EMail(String from, List<String> to, String subject, String text) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
    }
}
