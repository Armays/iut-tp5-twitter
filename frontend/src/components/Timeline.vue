<template>
  <div>
    <utilisateurs @changed="userChanged"></utilisateurs>
    <feed :tweets="tweets" :loading="loading" :connectedUser="handle" @retweeted="retweet"></feed>
  </div>
</template>

<script>
import Feed from './Feed'
import Utilisateurs from './Utilisateurs'
import Vue from 'vue'
import Resource from 'vue-resource'

Vue.use(Resource)
export default {
  name: 'timeline',
  data () {
              return {
                       tweets: [],
                       loading: true,
                       handle: ''
                     }
            },
    created () {
      setTimeout(function(){
        this.fetchTweets()
        }.bind(this), 2000);
    },
    methods: {
      fetchTweets: function () {
        // GET /someUrl
          this.$http.get('http://localhost:8080/list').then(response => {

            // get body data
                            this.tweets = response.body;
                            this.loading = false;
          }, response => {
            // error callback
          });
      },
      retweet: function (id) {
         console.log('id', id);
         var tweet = this.tweets.find(e => e.id === id);
         console.log(tweet.retweeters);
         var handle = this.tweets.find(e => e.handle === handle);
         tweet.retweeters.push({handle:handle});
      },
      userChanged: function (handle) {
        this.handle = handle
      }
    },
  components: {Feed, Utilisateurs}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
