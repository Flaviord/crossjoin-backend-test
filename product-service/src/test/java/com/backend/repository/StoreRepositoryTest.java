package com.backend.repository;

import com.backend.entities.Store;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StoreRepositoryTest {

    @Autowired
    private StoreRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(StoreRepository.class);
        entityManager = Mockito.mock(TestEntityManager.class);
    }

    @AfterEach
    void tearDown() {}

    @Test
    void injected_Components_Are_Not_Null(){
        Assertions.assertNotNull(entityManager);
        Assertions.assertNotNull(repository);
    }

    @Test
    public void test_find_store_by_id() {
        Store store = new Store();
        store.setName("xyz");
        store.setId(1L);
        store.setProducts(Collections.emptySet());
        store.setCreated(new Date());

        Mockito.when(repository.getById(1L)).thenReturn(store);
        Store st = repository.getById(1L);

        Assertions.assertNotNull(st.getId());
    }

    @Test
    public void test_find_list_store() {
        Store store1 = new Store();
        Store store2 = new Store();

        entityManager.persist(store1);
        entityManager.persist(store2);

        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(store1, store2));
        List<Store> storeList = repository.findAll();
        Assertions.assertEquals(storeList.size(), 2);
    }

}