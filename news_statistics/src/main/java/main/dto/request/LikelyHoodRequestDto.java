package main.dto.request;

import main.dto.NewsDto;


public class LikelyHoodRequestDto {
    private boolean country;
    private boolean gender;
    private NewsDto newsDto;

    public boolean isCountry() {
        return country;
    }

    public void setCountry(boolean country) {
        this.country = country;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public NewsDto getNewsDto() {
        return newsDto;
    }

    public void setNewsDto(NewsDto newsDto) {
        this.newsDto = newsDto;
    }

    public LikelyHoodRequestDto() {

    }

    public LikelyHoodRequestDto(boolean country, boolean gender, NewsDto newsDto) {

        this.country = country;
        this.gender = gender;
        this.newsDto = newsDto;
    }
}
