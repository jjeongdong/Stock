package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

//    @Transactional
    public synchronized void decrease_1(Long id, Long quantity) {
        // Stock 조회
        Stock stock = stockRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        // 재고 감소
        stock.decrease(quantity);
        // 갱신된 값을 저장
        stockRepository.saveAndFlush(stock);
    }

    @Transactional
    public void decrease_2(Long id, Long quantity) {
        // Stock 조회
        Stock stock = stockRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        // 재고 감소
        stock.decrease(quantity);
    }
}
