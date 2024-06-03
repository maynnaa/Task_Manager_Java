package com.emsi.web.app.services;

import com.emsi.web.app.dto.projet_dto;

import java.util.List;

public interface projet_service {
    List<projet_dto> findAllprojects();
}
