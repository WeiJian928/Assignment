package com.example.assignment.data.repository

import com.example.assignment.data.model.UserProfile
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest
class UserRepository(
    private val supabase: SupabaseClient
) {
    suspend fun storeProfile(currentEmail: String, currentPassword: String): Result<Unit> {
        return runCatching {
            // Authenticate with Supabase Auth
            supabase.auth.signInWith(Email) {
                email = currentEmail
                password = currentPassword
            }

            val session = supabase.auth.currentSessionOrNull()

            // Get authenticated user's ID
            val currentId = supabase.auth.currentUserOrNull()?.id
                ?: throw Exception("Authentication succeeded, user session missing")

            val currentToken = session?.accessToken ?: ""

            // Create profile object
            val userProfile = UserProfile(
                id = currentId,
                email = currentEmail,
                token = currentToken
            )

            // Save and update profile in Supabase ('profiles' table)
            supabase.postgrest["profiles"].upsert(userProfile)
        }
    }
}