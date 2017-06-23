<template>
  <div>
  <feed :tweets="tweets" :loading="loading" @retweeted="retweet"></feed>
  </div>
</template>

<script>
import Feed from './Feed'
import Vue from 'vue'
import Resource from 'vue-resource'

Vue.use(Resource)
export default {
  name: 'timeline',
  data () {
              return {
                       tweets: [],
                       loading: true
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
         tweet.retweeters.push({handle:'johndoe'});
      }
    },
  components: {Feed}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
