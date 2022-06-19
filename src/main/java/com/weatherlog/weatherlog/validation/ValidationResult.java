package com.weatherlog.weatherlog.validation;

import java.util.Optional;

public interface ValidationResult {

    static ValidationResult valid() {
        return ValidationSupport.valid();
    }

    static ValidationResult inValid(String reason){
        return new Invalid(reason);
    }

    boolean isValid();

    Optional<String> getReason();

     final class ValidationSupport {
         private static final ValidationResult valid = new ValidationResult() {
             public boolean isValid() {
                 return true;
             }

             public Optional<String> getReason() {
                 return Optional.empty();
             }
         };

         static ValidationResult valid() {
             return valid;
         }
     }

     final class Invalid implements ValidationResult{

        private final String reason;

        Invalid(String reason){
            this.reason = reason;
        }

        @Override
        public boolean isValid() {
            return false;
        }

        @Override
        public Optional<String> getReason() {
            return Optional.of(reason);
        }
    }
}
