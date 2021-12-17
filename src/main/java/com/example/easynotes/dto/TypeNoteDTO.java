package com.example.easynotes.dto;

import com.example.easynotes.model.Note;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class TypeNoteDTO implements Serializable {
    private Note.TypeNote type;

    public TypeNoteDTO() {}

    @Override
    public String toString() {
        String outString;
        switch(this.type) {
            case Highlight:
                outString = "Highlight";
                break;
            case OfInterest:
                outString = "OfInterest";
                break;
            case Normal:
                outString = "Normal";
                break;
            default:
                outString = "NoType";
                break;
        }
        return outString;
    }

    public void setType(Note.TypeNote type) {
        this.type = type;
    }
}
