package com.sonchayan.UserService.exceptionHandler;

  public class CredentialNotMatchedException extends Exception{
      public CredentialNotMatchedException() {
      }

      public CredentialNotMatchedException(String message) {
          super(message);
      }
  }
