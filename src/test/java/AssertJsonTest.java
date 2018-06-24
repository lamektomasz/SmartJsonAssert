import org.junit.jupiter.api.Test;
import smartjsonassert.assertion.AssertJson;

class AssertJsonTest {


/*    @Test
    public void shouldThrowAssertionError() throws AssertionError {
        assertThrows(AssertionError.class, () -> AssertJson.assertJson("test assertion error", "{test:\"fdsfdsfsd\"}", "{}"));
    }*/


    @Test
    public void shouldNotThrowException() {
        new AssertJson().assertJson("", getExpected(), getActual());
    }

    private String getActual() {
        return "[\n" +
                "  {\n" +
                "    \"_id\": \"5b2fbeda6ab74a98ff56e7bf\",\n" +
                "    \"index\": 0,\n" +
                "    \"guid\": \"bc71120d-5c23-46f5-8a2d-1533547b3b63\",\n" +
                "    \"isActive\": false,\n" +
                "    \"balance\": \"$1,359.82\",\n" +
                "    \"picture\": \"http://placehold.it/32x32\",\n" +
                "    \"age\": 35,\n" +
                "    \"eyeColor\": \"brown\",\n" +
                "    \"name\": {\n" +
                "      \"first\": \"Kramers\",\n" +
                "      \"last\": \"Faulkner\"\n" +
                "    },\n" +
                "    \"email\": \"kramer.faulkner@geekmosis.us\",\n" +
                "    \"phone\": \"+1 (848) 582-3023\",\n" +
                "    \"address\": \"954 Suydam Street, Muir, Kansas, 7293\",\n" +
                "    \"about\": \"Sunt dolore veniam et magna enim laborum nisi aliqua officia. Aliquip non voluptate proident irure nulla laborum nisi deserunt aute. Cillum Lorem magna dolore labore officia mollit ut dolore nulla mollit duis laboris. Non esse adipisicing ad ipsum ad cillum laboris eiusmod sit laboris. Adipisicing sit occaecat eiusmod sit magna. Duis esse dolore anim tempor officia anim proident aute nulla pariatur officia laborum sunt.\",\n" +
                "    \"registered\": \"Thursday, February 22, 2018 5:10 AM\",\n" +
                "    \"latitude\": \"71.741021\",\n" +
                "    \"longitude\": \"133.962605\",\n" +
                "    \"tags\": [\n" +
                "      \"excepteur\",\n" +
                "      \"sint\",\n" +
                "      \"eiusmod\",\n" +
                "      \"sunt\",\n" +
                "    ],\n" +
                "    \"range\": [\n" +
                "      0,\n" +
                "      1,\n" +
                "      2,\n" +
                "      3,\n" +
                "      4,\n" +
                "      5,\n" +
                "      6,\n" +
                "      7,\n" +
                "      8,\n" +
                "      9\n" +
                "    ],\n" +
                "    \"friends\": [\n" +
                "      {\n" +
                "        \"id\": 0,\n" +
                "        \"name\": \"Robbins Hess\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Delacruz Maynard\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Hewitt Moss\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"greeting\": \"Hello, Kramer! You have 9 unread messages.\",\n" +
                "    \"favoriteFruit\": \"apple\"\n" +
                "  }\n" +
                "]";
    }

    private String getExpected() {
        return "[\n" +
                "  {\n" +
                "    \"_id\": \"5b2fbeda6ab74a98ff56e7bf\",\n" +
                "    \"index\": 0,\n" +
                "    \"guid\": \"bc71120d-5c23-46f5-8a2d-1533547b3b63\",\n" +
                "    \"isActive\": false,\n" +
                "    \"balance\": \"$1,359.82\",\n" +
                "    \"picture\": \"http://placehold.it/32x32\",\n" +
                "    \"age\": 35,\n" +
                "    \"eyeColor\": \"brown\",\n" +
                "    \"name\": {\n" +
                "      \"first\": \"Kramer\",\n" +
                "      \"last\": \"Faulkner\"\n" +
                "    },\n" +
                "    \"company\": \"GEEKMOSIS\",\n" +
                "    \"email\": \"kramer.faulkner@geekmosis.us\",\n" +
                "    \"phone\": \"+1 (848) 582-3023\",\n" +
                "    \"address\": \"954 Suydam Street, Muir, Kansas, 7293\",\n" +
                "    \"about\": \"Sunt dolore veniam et magna enim laborum nisi aliqua officia. Aliquip non voluptate proident irure nulla laborum nisi deserunt aute. Cillum Lorem magna dolore labore officia mollit ut dolore nulla mollit duis laboris. Non esse adipisicing ad ipsum ad cillum laboris eiusmod sit laboris. Adipisicing sit occaecat eiusmod sit magna. Duis esse dolore anim tempor officia anim proident aute nulla pariatur officia laborum sunt.\",\n" +
                "    \"registered\": \"Thursday, February 22, 2018 5:10 AM\",\n" +
                "    \"latitude\": \"71.741021\",\n" +
                "    \"longitude\": \"133.962605\",\n" +
                "    \"tags\": [\n" +
                "      \"excepteur\",\n" +
                "      \"sint\",\n" +
                "      \"eiusmod\",\n" +
                "      \"sunt\",\n" +
                "      \"ex\"\n" +
                "    ],\n" +
                "    \"range\": [\n" +
                "      0,\n" +
                "      1,\n" +
                "      2,\n" +
                "      3,\n" +
                "      4,\n" +
                "      5,\n" +
                "      6,\n" +
                "      7,\n" +
                "      8,\n" +
                "      9\n" +
                "    ],\n" +
                "    \"friends\": [\n" +
                "      {\n" +
                "        \"id\": 0,\n" +
                "        \"name\": \"Robbins Hess\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Delacruz Maynard\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Hewitt Moss\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"greeting\": \"Hello, Kramer! You have 9 unread messages.\",\n" +
                "    \"favoriteFruit\": \"apple\"\n" +
                "  }\n" +
                "]";
    }

}