package com.jarida.server.jaridaserver.quranlyfeAPI.repository;

import com.jarida.server.jaridaserver.quranlyfeAPI.model.QuranLyfeNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuranLyfeNotificationRepository extends JpaRepository<QuranLyfeNotification, Long> {

}
