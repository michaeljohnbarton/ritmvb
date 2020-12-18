<!--
  File:         Schedule.vue
  Author:       Michael Barton
  Description:  The Schedule view which displays all of the events coming up for the club
                Gets these events from the Google Calendar API
-->

<template>
  <div class="schedule">
    <Page>
    </Page>
  </div>
</template>

<script>
export default {
  name: "Schedule",
  components: {
    Page: () => import("@/components/general/Page.vue")
  }
};
</script>
