package com.example.cloud_tracker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.cloud_tracker.repository.IAMRoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IAMRoleTest {

    private IAMRole iamRole;

    @Mock
    private IAMRoleRepository iamRoleRepository;

    @BeforeEach
    void setUp() {
        iamRole = new IAMRole("123456789012", "testRole", 1);
    }

    @Test
    void testIAMRoleConstructor() {
        assertEquals("123456789012", iamRole.getAccountID());
        assertEquals("testRole", iamRole.getRoleName());
        assertEquals(1, iamRole.getUserId());
    }


    @Test
    void testIAMRoleRepository() {
        when(iamRoleRepository.save(iamRole)).thenReturn(iamRole);
        assertEquals(iamRole, iamRoleRepository.save(iamRole));
    }

    @Test
    void testAllArgsConstructor() {
        IAMRole anotherIAMRole = new IAMRole("987654321098", "anotherTestRole","arntest", 2);
        assertEquals("987654321098", anotherIAMRole.getAccountID());
        assertEquals("anotherTestRole", anotherIAMRole.getRoleName());
        assertEquals("arntest", anotherIAMRole.getArn());
        assertEquals(2, anotherIAMRole.getUserId());
    }

    @Test
    void testDataAnnotation() {
        IAMRole roleWithEquals = new IAMRole("123456789012", "testRole", 1);
        IAMRole roleWithToString = new IAMRole("123456789012", "testRole", 1);

        assertEquals(roleWithEquals, roleWithToString);
        assertEquals(roleWithEquals.hashCode(), roleWithToString.hashCode());
    }

    @Test
    void testSetters() {
        iamRole.setAccountID("098765432109");
        iamRole.setRoleName("updatedRole");
        iamRole.setUserId(3);
        iamRole.setArn("arn");

        assertEquals("098765432109", iamRole.getAccountID());
        assertEquals("updatedRole", iamRole.getRoleName());
        assertEquals("arn", iamRole.getArn());
        assertEquals(3, iamRole.getUserId());
    }

    @Test
    void testToString() {
        String expectedToString = "IAMRole(accountID=123456789012, roleName=testRole, arn=null, userId=1)";
        assertEquals(expectedToString, iamRole.toString());
    }
}
