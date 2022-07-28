package com.ecommerceapi.service.impl;

import com.ecommerceapi.entity.Product;
import com.ecommerceapi.entity.TemporaryBasket;
import com.ecommerceapi.repository.ProductRepository;
import com.ecommerceapi.repository.TemporaryBasketRepository;
import com.ecommerceapi.service.TemporaryBasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TemporaryBasketImpl implements TemporaryBasketService {

    private final TemporaryBasketRepository temporaryBasketRepository;

    private final ProductRepository productRepository;



    @Override
    public String add(TemporaryBasket data) {

        int basketCookieId = 0;
        Random rnd = new Random();
        // Üretilen Sayı Temporary Basket  ve Order Tablosunda var ise Tekrar Sayı üretecek. Yok ise üretilen ile devam edilecek.
        do
        {
            basketCookieId = rnd.nextInt(9000000);
        }
        while((temporaryBasketRepository.basketCookieControl(basketCookieId) != null) ||
                (temporaryBasketRepository.orderCookieControl(basketCookieId) != null));

        data.cookieBasketId = basketCookieId;
        try
        {
            temporaryBasketRepository.save(data);
            return "İşlem Başarılı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    @Override
    public List<TemporaryBasket> getAll(int cookieId) {
        return temporaryBasketRepository.getAllList(cookieId);
    }

    @Override
    public TemporaryBasket getById(int Id) {
        return temporaryBasketRepository.findById(Id).orElse(null);
    }

    @Override
    public String delete(int Id) {
        try
        {
            temporaryBasketRepository.deleteById(Id);
            return "İşlem Başarılı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @Override
    public String update(int basketId, boolean Status) {
        try
        {
            TemporaryBasket dataKontrol = temporaryBasketRepository.sepetAdetKontrol(basketId);
            if(dataKontrol != null) // Gönderilen Ürün Sepette Varmı ?
            {
                Product bulunanUrun  = productRepository.findById(dataKontrol.productId).orElse(null);
                if(Status)
                {
                    if(bulunanUrun.stock > dataKontrol.piece ) // Ürün'ün Depo'daki Stoğuna bakılıp Kontrol ediliyor.
                    {
                        dataKontrol.piece++; // Depodaki Ürünün Adeti, Alınmak istenen Adet'ten yüksek ise 1 Arttır.
                    }
                    else
                    {
                        return "Maximum " + bulunanUrun.stock + " Adet Sipariş Verebilirsiniz";
                    }
                }
                else
                {
                    if( 1 < dataKontrol.piece)  // ALınmak istenilen ürün Adeti 1'den yüksek ise adet'i azalt.
                    {
                        dataKontrol.piece--;
                    }
                    else
                    {
                        return "Minimum 1 Adet Ürün Satın Alabilirsiniz";
                    }
                }
            }
            temporaryBasketRepository.save(dataKontrol);
            return "İşlem Başarılı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

}
