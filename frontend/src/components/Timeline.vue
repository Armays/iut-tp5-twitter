<template>
  <div>
    <utilisateurs @changed="userChanged"></utilisateurs>
    <br>
    <PostTweet :connectedUser="handle" @newTweet="postTweet"></PostTweet>
    <br>
    <feed :tweets="tweets" :loading="loading" :connectedUser="handle" @retweeted="retweet"></feed>
  </div>
</template>

<script>
import Feed from './Feed'
import PostTweet from './PostTweet'
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
      handle: undefined,
      id : undefined
    }
  },
  created () {
    setTimeout(function(){
      this.fetchTweets();
      }.bind(this), 2000);
  },
  methods: {
    fetchTweets: function () {
      this.$http.get('http://localhost:8080/list').then(response => {
        this.tweets = response.body;
        this.loading = false;
      }, response => {
        // error callback
      });
    },
    retweet: function (id) {
      var tweet = this.tweets.find(e => e.id === id);
      var handle = this.tweets.find(e => e.handle === handle);
      tweet.retweeters.push({handle:handle});
    },
    userChanged: function (handle) {
      this.handle = handle;
    },
    postTweet: async function(newTweet) {
      var data = new FormData();
      data.append('auteur', this.handle);
      data.append('contenu', newTweet);
      var postedTweet = await this.$http.post('http://localhost:8080/tweet', data);
      postedTweet.body.retweeters = [];
      this.tweets.unshift(postedTweet.body);
    }
  },
  components: {Feed, Utilisateurs, PostTweet}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
