import { shallowMount, createLocalVue } from '@vue/test-utils'
import Vue from 'vue'
import App from '@/App.vue'
import Vuetify from 'vuetify'

describe('App.vue', () => {
    Vue.use(Vuetify)

    let localVue
    let wrapper
    let $route

    beforeAll(() => {
        localVue = createLocalVue()
        localVue.use(Vuetify, {})

        $route = {
            name: 'ContactUs'
        }
    })

    describe('insertSpacesWhereUpperCase()', () => {
        beforeAll(() => {
            wrapper = shallowMount(App, {
                localVue,
                mocks: {
                    $route
                },
                stubs: ['router-link', 'router-view']
            })
        })

        it('returns empty string for empty string', () => {
            // Act
            var actual = wrapper.vm.insertSpacesWhereUpperCase("")

            // Assert
            expect(actual).toBe("")
        })

        it('returns "About" for "About"', () => {
            // Act
            var actual = wrapper.vm.insertSpacesWhereUpperCase("About")

            // Assert
            expect(actual).toBe("About")
        })

        it('returns "Contact Us" for "ContactUs"', () => {
            // Act
            var actual = wrapper.vm.insertSpacesWhereUpperCase("ContactUs")

            // Assert
            expect(actual).toBe("Contact Us")
        })

        it('returns "Contact Us" for "Contact Us"', () => {
            // Act
            var actual = wrapper.vm.insertSpacesWhereUpperCase("Contact Us")

            // Assert
            expect(actual).toBe("Contact Us")
        })
    })

    describe('currentRouteName()', () => {
        beforeAll(() => {
            wrapper = shallowMount(App, {
                localVue,
                mocks: {
                    $route,
                    insertSpacesWhereUpperCase: x => x
                },
                stubs: ['router-link', 'router-view']
            })
        })

        it('returns route name of Vue instance', () => {
            // Act
            var actual = wrapper.vm.currentRouteName

            // Assert
            // Note: this comes from mock of $route in beforeAll() near top of file
            expect(actual).toBe("ContactUs")
        })
    })
})