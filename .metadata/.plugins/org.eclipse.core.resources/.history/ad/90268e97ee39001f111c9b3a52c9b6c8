package com.touristguide.entity;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tourist_guides1")
public class TouristGuide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Location is mandatory")
    @Size(max = 100, message = "Location cannot exceed 100 characters")
    private String location;

    @NotNull(message = "Languages are mandatory")
    @Size(min = 1, message = "At least one language must be specified")
    private List<String> languages;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    @NotNull(message = "Average rating is mandatory")
    private Double averageRating;

    // You may want to store the photo as a URL or a file path
    @Lob
    private byte[] photo;

    @NotBlank(message = "Contact number is mandatory")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be 10 digits")
    private String contactNumber;

    @NotBlank(message = "Aadhar number is mandatory")
    @Pattern(regexp = "^[0-9]{12}$", message = "Aadhar number must be 12 digits")
    private String aadharNumber;

    public TouristGuide() {
        super();
    }

    public TouristGuide(Long id, String name, String location, List<String> languages, String description, String email,
                        Double averageRating, byte[] photo, String contactNumber, String aadharNumber) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.languages = languages;
        this.description = description;
        this.email = email;
        this.averageRating = averageRating;
        this.photo = photo;
        this.contactNumber = contactNumber;
        this.aadharNumber = aadharNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    @Override
    public String toString() {
        return "TouristGuide [id=" + id + ", name=" + name + ", location=" + location + ", languages=" + languages
                + ", description=" + description + ", email=" + email + ", averageRating=" + averageRating + ", photo="
                + Arrays.toString(photo) + ", contactNumber=" + contactNumber + ", aadharNumber=" + aadharNumber + "]";
    }
}
