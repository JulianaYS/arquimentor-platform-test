Feature: Adding a Publication
  As a Developer
  I want to add a publication through the API
  So that it can be available to applications.

  Background:
    Given the endpoint "https://localhost:%d/api/v1/publications" is available

  @publication-adding
  Scenario: Add a Publication
    When a POST Request is sent with values "Maqueta de edificio antisismos", "Estructura diseñada y construida para resistir terremotos de manera eficaz.", "image_url_1", 1
    Then a Response is received with Status 200
