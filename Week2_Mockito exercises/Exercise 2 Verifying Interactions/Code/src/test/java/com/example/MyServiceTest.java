package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create a mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Pass the mock into the class under test
        MyService service = new MyService(mockApi);

        // Step 3: Call the method which should trigger mockApi.getData()
        service.fetchData();

        // Step 4: Verify that the mock method was called
        verify(mockApi).getData();
    }
}